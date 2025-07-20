#!/bin/bash

# FashionStore Collaborative Cart - Setup Script

echo "🛒 FashionStore Collaborative Cart Setup"
echo "========================================"

# Check if we're in the right directory
if [ ! -f "cart.html" ]; then
    echo "❌ Error: Please run this script from the FashionStore-pro directory"
    exit 1
fi

echo "✅ Found FashionStore project files"

# Check for required files
echo "📁 Checking project structure..."

if [ -f "collaborator/collaborator_card.html" ]; then
    echo "✅ Collaborator dashboard found"
else
    echo "❌ Collaborator dashboard missing"
fi

if [ -f "collaborator/firebase-config.js" ]; then
    echo "✅ Firebase configuration found"
else
    echo "❌ Firebase configuration missing"
fi

if [ -f "products.html" ]; then
    echo "✅ Products page found"
else
    echo "❌ Products page missing"
fi

echo ""
echo "🚀 Starting local development server..."

# Try different server options
if command -v python3 &> /dev/null; then
    echo "📡 Starting Python HTTP server on port 8000..."
    echo "🌐 Open your browser to:"
    echo "   - Products: http://localhost:8000/products.html"
    echo "   - Cart: http://localhost:8000/cart.html"
    echo "   - Collaborator: http://localhost:8000/collaborator/collaborator_card.html"
    echo ""
    echo "💡 Tip: Open the collaborator link in a separate window/device for testing"
    echo "🔄 Press Ctrl+C to stop the server"
    echo ""
    python3 -m http.server 8000
elif command -v python &> /dev/null; then
    echo "📡 Starting Python HTTP server on port 8000..."
    echo "🌐 Open your browser to:"
    echo "   - Products: http://localhost:8000/products.html"
    echo "   - Cart: http://localhost:8000/cart.html"
    echo "   - Collaborator: http://localhost:8000/collaborator/collaborator_card.html"
    echo ""
    echo "💡 Tip: Open the collaborator link in a separate window/device for testing"
    echo "🔄 Press Ctrl+C to stop the server"
    echo ""
    python -m SimpleHTTPServer 8000
elif command -v node &> /dev/null; then
    if command -v npx &> /dev/null; then
        echo "📡 Starting Node.js HTTP server on port 8000..."
        echo "🌐 Open your browser to:"
        echo "   - Products: http://localhost:8000/products.html"
        echo "   - Cart: http://localhost:8000/cart.html"
        echo "   - Collaborator: http://localhost:8000/collaborator/collaborator_card.html"
        echo ""
        echo "💡 Tip: Open the collaborator link in a separate window/device for testing"
        echo "🔄 Press Ctrl+C to stop the server"
        echo ""
        npx http-server -p 8000
    else
        echo "❌ npx not found. Please install Node.js with npm"
        exit 1
    fi
elif command -v php &> /dev/null; then
    echo "📡 Starting PHP development server on port 8000..."
    echo "🌐 Open your browser to:"
    echo "   - Products: http://localhost:8000/products.html"
    echo "   - Cart: http://localhost:8000/cart.html"
    echo "   - Collaborator: http://localhost:8000/collaborator/collaborator_card.html"
    echo ""
    echo "💡 Tip: Open the collaborator link in a separate window/device for testing"
    echo "🔄 Press Ctrl+C to stop the server"
    echo ""
    php -S localhost:8000
else
    echo "❌ No suitable HTTP server found."
    echo "Please install one of the following:"
    echo "  - Python 3: brew install python3"
    echo "  - Node.js: brew install node"
    echo "  - PHP: brew install php"
    echo ""
    echo "Or manually serve the files using your preferred method."
    echo ""
    echo "📝 Manual setup:"
    echo "1. Serve this directory on a local HTTP server"
    echo "2. Open products.html to browse products"
    echo "3. Add products to cart and view cart.html"
    echo "4. Open collaborator/collaborator_card.html in another window"
    echo "5. React to products and see AI suggestions!"
fi
