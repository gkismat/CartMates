# FashionStore Collaborative Cart System

A collaborative e-commerce cart system that allows collaborators to provide real-time feedback on products, with AI-powered purchase recommendations.

## Features

### 🛒 Smart Cart System
- **Real-time Product Management**: Add, remove, and update quantities
- **Dynamic Pricing**: Automatic total calculations with tax and shipping
- **Persistent Storage**: Cart data saved in localStorage and Firebase

### 👥 Collaborator Features
- **Multi-Modal Reactions**: Emoji reactions, text messages, and voice recordings
- **Real-time Feedback**: Instant synchronization between collaborator and user views
- **Voice Messages**: Record and playback audio reactions using Web API

### 🤖 AI Integration
- **Smart Recommendations**: AI analyzes collaborator feedback to suggest "Buy" or "Skip"
- **Sentiment Analysis**: Processes emoji reactions and text messages
- **Confidence Scoring**: Provides confidence levels for recommendations
- **Real-time Popups**: Instant suggestions displayed to users

### 🔥 Firebase Integration
- **Real-time Database**: Firestore for storing reactions and suggestions
- **File Storage**: Firebase Storage for voice message recordings
- **Cross-device Sync**: Works across multiple devices and browsers

## Prototype Showcase

- **Live Demo URL**: [Link to your live demo]
- **Deployed App**: [Link to your hosted instance]
- **Source-Code Repository**: [Link to your GitHub or other repo]

## Project Structure

```
Sharedcart 2/
├── app.py                       # Python Flask backend
├── requirements.txt             # Python dependencies
├── FashionStore-pro/
│   ├── Readme.txt               # This file
│   ├── cart.html                # Main shopping cart page
│   ├── products.html            # Product listing page
│   ├── collaborator/
│   │   ├── collaborator_card.html # Collaborator dashboard
│   │   └── firebase-config.js   # Firebase configuration
│   └── assets/                  # CSS, JS, and images
...
```

## Setup Instructions

### 1. Firebase Setup

1. **Create Firebase Project**:
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project
   - Enable Firestore Database
   - Enable Storage

2. **Configure Firebase**:
   - Update `collaborator/firebase-config.js` with your Firebase credentials:
   ```javascript
   const firebaseConfig = {
     apiKey: "your-api-key",
     authDomain: "your-project.firebaseapp.com",
     projectId: "your-project-id",
     storageBucket: "your-project.appspot.com",
     messagingSenderId: "your-sender-id",
     appId: "your-app-id"
   };
   ```

3. **Database Rules** (Firestore):
   ```javascript
   rules_version = '2';
   service cloud.firestore {
     match /databases/{database}/documents {
       match /{document=**} {
         allow read, write: if true; // For demo purposes
       }
     }
   }
   ```

4. **Storage Rules**:
   ```javascript
   rules_version = '2';
   service firebase.storage {
     match /b/{bucket}/o {
       match /{allPaths=**} {
         allow read, write: if true; // For demo purposes
       }
     }
   }
   ```

### 2. Run Locally

To run this project, you need two separate servers: one for the Python backend and one for the HTML/CSS frontend.

**A. Running the Backend (Flask Server)**

The backend handles AI suggestions and other server-side logic.

1.  **Navigate to the project root directory:**
    Replace `"path/to/Sharedcart 2"` with the actual path on your computer.
    ```bash
    cd "path/to/Sharedcart 2"
    ```

2.  **Create and activate a Python virtual environment:** This isolates the project's dependencies.
    ```bash
    # For macOS/Linux
    python3 -m venv venv
    source venv/bin/activate

    # For Windows
    # python -m venv venv
    # venv\Scripts\activate
    ```

3.  **Install the required Python libraries:**
    This project uses a `requirements.txt` file to manage all backend dependencies.
    ```bash
    pip install -r requirements.txt
    ```

4.  **Start the Flask backend server:**
    ```bash
    python3 app.py
    ```
    The backend will now be running at `http://127.0.0.1:5000`. Keep this terminal open.

**B. Running the Frontend (Web Server)**

The frontend serves the store's HTML, CSS, and JavaScript files.

1.  **Open a new terminal window or tab.**

2.  **Navigate to the frontend directory:**
    ```bash
    cd "path/to/Sharedcart 2/FashionStore-pro"
    ```

3.  **Start a simple Python web server:**
    ```bash
    python3 -m http.server 8000
    ```
    The frontend server will now be running.

4.  **Access the Application:**
    With both servers running, you can now use the application. Open your web browser and navigate to the following pages:
    - **Main Store:** [http://localhost:8000/products.html](http://localhost:8000/products.html)
    - **Shopping Cart:** [http://localhost:8000/cart.html](http://localhost:8000/cart.html)
    - **Collaborator View:** [http://localhost:8000/collaborator/collaborator_card.html](http://localhost:8000/collaborator/collaborator_card.html)

### 3. Usage Flow

1. **Add Products**:
   - Visit `products.html`
   - Browse and add products to cart
   - View cart at `cart.html`

2. **Collaborator Feedback**:
   - Open `collaborator/collaborator_card.html` in a separate window/device
   - React to products with emojis, messages, or voice recordings
   - Send reactions using the "Send Reaction" button

3. **AI Suggestions**:
   - Reactions automatically trigger AI analysis
   - Users receive real-time recommendation popups
   - Suggestions include "Buy" or "Skip" with confidence levels

## Technical Implementation

### Data Flow
1. **Products** → Added to cart → Stored in localStorage + Firebase
2. **Collaborator** → Reacts to products → Reactions stored in Firebase
3. **AI System** → Analyzes reactions → Generates suggestions
4. **User** → Receives suggestions → Makes informed decisions

### Real-time Synchronization
- **Firebase Firestore**: Real-time database updates
- **Storage Events**: Cross-tab communication
- **WebRTC**: Voice message recording and playback

### AI Suggestion Algorithm
The AI-powered suggestions are generated by a sentiment analysis model running in the Python backend (`app.py`). Here’s how it works:

1.  **Model**: It uses a pre-trained model from the Hugging Face `transformers` library, specifically designed for sentiment analysis.
2.  **Input**: The model takes the text from collaborator messages as input.
3.  **Processing**: The text is tokenized and fed into the model.
4.  **Output**: The model outputs a classification (e.g., "POSITIVE", "NEGATIVE", "NEUTRAL") and a confidence score.
5.  **Recommendation**:
    -   A **POSITIVE** sentiment with high confidence translates to a "BUY" recommendation.
    -   A **NEGATIVE** sentiment results in a "SKIP" recommendation.
    -   Emoji reactions are also factored in, with positive emojis (e.g., 👍, ❤️) reinforcing a "BUY" decision and negative ones (e.g., 👎) reinforcing a "SKIP."

## Backend Dependencies (`requirements.txt`)

flask
flask_cors
pyttsx3
googletrans-py
transformers
torch

## Open-Source Attribution

This project leverages several open-source libraries, frameworks, and tools. Below is a list of attributions as required.

| Name & Version                 | License Type        | Role in Build                                       | Source Link                                                              |
| ------------------------------ | ------------------- | --------------------------------------------------- | ------------------------------------------------------------------------ |
| **Frontend**                   |                     |                                                     |                                                                          |
| Bootstrap v5.3.x               | MIT                 | Core frontend framework for UI and layout.          | [https://getbootstrap.com/](https://getbootstrap.com/)                   |
| Bootstrap Icons v1.11.x        | MIT                 | Icon set used throughout the user interface.        | [https://icons.getbootstrap.com/](https://icons.getbootstrap.com/)       |
| Swiper JS                      | MIT                 | Powers the announcement bar and other sliders.      | [https://swiperjs.com/](https://swiperjs.com/)                           |
| AOS (Animate on Scroll)        | MIT                 | Provides animations as content enters the viewport. | [https://michalsnik.github.io/aos/](https://michalsnik.github.io/aos/)   |
| Glightbox                      | MIT                 | Used for creating lightboxes for product images.    | [https://biati-digital.github.io/glightbox/](https://biati-digital.github.io/glightbox/) |
| Isotope Layout                 | GPL-3.0             | For filterable, sortable grid layouts.              | [https://isotope.metafizzy.co/](https://isotope.metafizzy.co/)           |
| Firebase SDK v9.23.0           | Apache 2.0          | Handles real-time database and cloud storage.       | [https://firebase.google.com/](https://firebase.google.com/)             |
| **Backend**                    |                     |                                                     |                                                                          |
| Flask                          | BSD-3-Clause        | Python web framework for the backend server.        | [https://flask.palletsprojects.com/](https://flask.palletsprojects.com/) |
| Flask-Cors                     | MIT                 | Manages Cross-Origin Resource Sharing (CORS).       | [https://github.com/corydolphin/flask-cors](https://github.com/corydolphin/flask-cors) |
| pyttsx3                        | BSD License         | Library for text-to-speech conversion.              | [https://github.com/nateshmbhat/pyttsx3](https://github.com/nateshmbhat/pyttsx3) |
| googletrans-py                 | MIT                 | Python library for using the Google Translate API.  | [https://github.com/sarathsp06/googletrans-py](https://github.com/sarathsp06/googletrans-py) |
| Transformers                   | Apache 2.0          | Powers the sentiment analysis AI model.             | [https://github.com/huggingface/transformers](https://github.com/huggingface/transformers) |
| PyTorch (torch)                | BSD-style           | The underlying framework for the AI model.          | [https://pytorch.org/](https://pytorch.org/)                             |
| **Template**                   |                     |                                                     |                                                                          |
| FashionStore Template          | BootstrapMade License | Base template for UI and conceptual inspiration.    | [https://bootstrapmade.com/fashion-store-bootstrap-template/](https://bootstrapmade.com/fashion-store-bootstrap-template/) |

## Troubleshooting

### Common Issues
1. **Voice recording not working**: Check microphone permissions
2. **Reactions not syncing**: Verify Firebase configuration
3. **Cart not updating**: Check localStorage and console errors
4. **AI suggestions not showing**: Ensure proper reaction data format

### Debug Tools
- Open browser console for error messages
- Check Firebase Console for database updates
- Verify network requests in Developer Tools

## Future Enhancements
- [ ] User authentication system
- [ ] Multiple collaborator support
- [ ] Advanced AI with machine learning
- [ ] Mobile app integration
- [ ] Social sharing features
- [ ] Analytics dashboard

## Support
For issues or questions, check the browser console for error messages and verify Firebase configuration.
