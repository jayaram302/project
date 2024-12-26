<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Happy New Year</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial, sans-serif';
            background: linear-gradient(to bottom, #ff9966, #ff5e62);
            color: white;
            text-align: center;
        }
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message {
            font-size: 2.5rem;
            margin-bottom: 20px;
            animation: glow 2s infinite alternate;
        }
        .decorations {
            display: flex;
            gap: 15px;
            margin: 20px 0;
        }
        .decorations span {
            font-size: 2rem;
            animation: float 3s infinite ease-in-out;
        }
        @keyframes glow {
            from {
                text-shadow: 0 0 10px #ffe4b5, 0 0 20px #ff4500, 0 0 30px #ff6347;
            }
            to {
                text-shadow: 0 0 20px #ffa07a, 0 0 30px #ff4500, 0 0 40px #ff6347;
            }
        }
        @keyframes float {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🎉 Happy New Year 2024! 🎆</h1>
        <p class="message">Wishing you joy, success, and endless blessings!</p>
        <div class="decorations">
            <span>🎇</span>
            <span>✨</span>
            <span>🎉</span>
            <span>🌟</span>
            <span>🎆</span>
        </div>
    </div>
</body>
</html>