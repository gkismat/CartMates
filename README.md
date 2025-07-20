
CARTMATES – COLLABORATIVE SHOPPING CART PLATFORM

A collaborative e-commerce cart system enabling users to manage a shared shopping cart, provide real-time feedback, and receive AI-powered purchase recommendations.

Frontend: Built using a modified Bootstrap template for a responsive UI.
Backend: Python Flask API using Hugging Face Transformers (sentiment analysis) and OpenAI Whisper (voice transcription, adapted and modified).
Realtime Features: Firebase for synchronization and cloud storage.

---

FEATURES

SMART CART SYSTEM

* Real-time product management (add, remove, update)
* Automatic total calculation (tax and shipping)
* Persistent storage: Cart data saved in localStorage and Firebase

COLLABORATOR FEATURES

* Multi-modal reactions: Emoji, text, and voice messages
* Instant real-time sync between user and collaborator views
* Voice message recording and playback (Web API)

AI & VOICE INTEGRATION

* AI suggestions: Sentiment analysis on collaborator feedback using pre-trained Hugging Face models
* Voice-to-text: Uses OpenAI Whisper (reference implementation, modified for this project)
* Sentiment and emoji-based "Buy" or "Skip" recommendations with confidence scoring

FIREBASE INTEGRATION

* Realtime Firestore database for reactions and cart data
* Firebase Storage for voice message recordings
* Cross-device and cross-browser sync

---

LIVE DEMO & SOURCE

Live Demo: Add your demo link here
Source Code: GitHub repo link

---

PROJECT STRUCTURE

CartMates/

* account.html
* assets/
* backend/
* cart.html
* category.html
* collaborator/
* demo.html
* forms/
* index.html
* login.html
* order-confirmation.html
* payment-methods.html
* product-details.html
* products.html
* register.html
* shipping-info.html
* shared-messages.html
* collaborator2.html
* Readme.txt
* start\_server.sh
* venv311/
* myenv/

---

SETUP INSTRUCTIONS

1. CLONE THE REPOSITORY

git clone [https://github.com/gkismat/CartMates.git](https://github.com/gkismat/CartMates.git)
cd CartMates

2. FIREBASE SETUP

* Go to Firebase Console: [https://console.firebase.google.com/](https://console.firebase.google.com/)
* Create a new project, enable Firestore Database and Storage
* Update collaborator/firebase-config.js with your Firebase credentials
  Example format:
  const firebaseConfig = {
  apiKey: "your-api-key",
  authDomain: "your-project.firebaseapp.com",
  projectId: "your-project-id",
  storageBucket: "your-project.appspot.com",
  messagingSenderId: "your-sender-id",
  appId: "your-app-id"
  };
* Set Firestore and Storage rules as needed (for demo, allow read/write for all)

3. BACKEND (FLASK) SETUP

* Create and activate a virtual environment:
  On Mac/Linux:
  python3 -m venv venv
  source venv/bin/activate
  On Windows:
  python -m venv venv
  venv\Scripts\activate
* Install Python dependencies:
  pip install -r requirements.txt
* Run the backend:
  python app.py
* The backend runs at [http://127.0.0.1:5000/](http://127.0.0.1:5000/)

4. FRONTEND SETUP

* cd FashionStore-pro
* python3 -m http.server 8000
* Open [http://localhost:8000/products.html](http://localhost:8000/products.html) for the main store, or other HTML files as needed

---

USAGE FLOW

1. Add products: Browse and add products via products.html
2. View cart: See your selections in cart.html
3. Collaborator feedback: Open collaborator/collaborator\_card.html on another device or window, provide feedback using text, emoji, or voice
4. AI suggestions: Receive instant "Buy" or "Skip" popups based on reactions

---

TECHNICAL IMPLEMENTATION

DATA FLOW

* Products are added to cart and stored in localStorage plus Firebase
* Collaborator reacts to products, reactions stored in Firebase
* AI system analyzes reactions and generates suggestions
* User receives suggestions and makes informed decisions

REAL-TIME SYNC

* Firebase Firestore: Real-time database updates for cart and reactions
* Storage: Firebase Storage for audio files
* Web APIs: For voice recording and playback

AI SUGGESTION ALGORITHM

* Model: Pre-trained Hugging Face Transformers for sentiment analysis (inference only)
* Voice: OpenAI Whisper used for speech-to-text (reference code, adapted for project)
* Recommendation Logic: Positive sentiment plus positive emojis means "Buy"; negative means "Skip"

---

OPEN SOURCE ATTRIBUTION

Library/Tool:    License:      Usage/Role:                            Source:

* Bootstrap v5.3.x        MIT         Core frontend framework (modified)           [https://getbootstrap.com/](https://getbootstrap.com/)
* FashionStore Template   BootstrapMade   UI template (base, modified)             [https://bootstrapmade.com/fashion-store-bootstrap-template/](https://bootstrapmade.com/fashion-store-bootstrap-template/)
* Bootstrap Icons         MIT         UI icons                                   [https://icons.getbootstrap.com/](https://icons.getbootstrap.com/)
* Swiper JS               MIT         Announcements/sliders                      [https://swiperjs.com/](https://swiperjs.com/)
* AOS                     MIT         Animation on scroll                        [https://michalsnik.github.io/aos/](https://michalsnik.github.io/aos/)
* Glightbox               MIT         Image lightbox                             [https://biati-digital.github.io/glightbox/](https://biati-digital.github.io/glightbox/)
* Isotope Layout          GPL-3.0     Grid layouts/filtering                     [https://isotope.metafizzy.co/](https://isotope.metafizzy.co/)
* Firebase SDK            Apache 2.0  Real-time DB, storage                      [https://firebase.google.com/](https://firebase.google.com/)
* Flask                   BSD-3-Clause Python backend                            [https://flask.palletsprojects.com/](https://flask.palletsprojects.com/)
* Flask-Cors              MIT         CORS for Flask                             [https://github.com/corydolphin/flask-cors](https://github.com/corydolphin/flask-cors)
* pyttsx3                 BSD         Text-to-speech                             [https://github.com/nateshmbhat/pyttsx3](https://github.com/nateshmbhat/pyttsx3)
* googletrans-py          MIT         Translation                                [https://github.com/sarathsp06/googletrans-py](https://github.com/sarathsp06/googletrans-py)
* Transformers            Apache 2.0  Sentiment analysis (pre-trained)           [https://github.com/huggingface/transformers](https://github.com/huggingface/transformers)
* torch                   BSD-style   ML/AI backend                              [https://pytorch.org/](https://pytorch.org/)
* OpenAI Whisper          MIT         Speech-to-text (reference, modified)        [https://github.com/openai/whisper](https://github.com/openai/whisper)

Notes:

* FashionStore Template and Bootstrap are used as a base and heavily modified for this project.
* OpenAI Whisper was used as a reference and integrated/modified for voice transcription.
* Hugging Face Transformers models are used for inference only (not retrained).

---

TROUBLESHOOTING

* Voice recording not working: Check browser microphone permissions
* Reactions not syncing: Verify Firebase configuration
* Cart not updating: Check localStorage and browser console for errors
* AI suggestions not showing: Ensure Flask backend is running and dependencies are installed

---

FUTURE ENHANCEMENTS

* User authentication system
* Multiple collaborator support
* Advanced AI with continuous learning
* Mobile app integration
* Analytics dashboard
* Social sharing features

---

LICENSE

This project is for educational/demo purposes and is distributed under the licenses of the open-source components used.
See LICENSE file for full terms.

---

CREDITS

* UI/UX based on BootstrapMade’s FashionStore template (modified).
* Voice-to-text: OpenAI Whisper (reference implementation, modified).
* Sentiment analysis: Hugging Face Transformers (pre-trained models).

For questions or issues, please open an issue in this repo.


