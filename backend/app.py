from flask import Flask, request, jsonify
import whisper
from transformers import MarianMTModel, MarianTokenizer

app = Flask(__name__)

# Load models
whisper_model = whisper.load_model("base")
tokenizer = MarianTokenizer.from_pretrained("Helsinki-NLP/opus-mt-hi-en")
translator_model = MarianMTModel.from_pretrained("Helsinki-NLP/opus-mt-hi-en")

def classify_text(text):
    text = text.lower()
    if "love" in text or "like" in text:
        return "Buy"
    if "bad" in text or "hate" in text:
        return "Skip"
    return "Skip"

@app.route("/process", methods=["POST"])
def process_audio():
    # NEW: If there's direct text (from JS), classify and return
    if "text" in request.form:
        english_text = request.form["text"]
        label = classify_text(english_text)
        return jsonify({
            "english_text": english_text,
            "classification": label
        })
    
    # Otherwise, handle audio (same as before)
    file = request.files["file"]
    filepath = "temp.wav"
    file.save(filepath)

    # Transcribe Hindi audio
    result = whisper_model.transcribe(filepath, language="hi")
    hindi_text = result["text"]

    # Translate Hindi -> English
    batch = tokenizer([hindi_text], return_tensors="pt", truncation=True, padding=True)
    gen = translator_model.generate(**batch)
    english_text = tokenizer.decode(gen[0], skip_special_tokens=True)

    # Classify
    label = classify_text(english_text)

    return jsonify({
        "hindi_text": hindi_text,
        "english_text": english_text,
        "classification": label
    })

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
