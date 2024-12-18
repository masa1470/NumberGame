<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>数字当てゲーム</title>
    <style>
        /* 全体のスタイル */
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #1d3557, #457b9d, #a8dadc);
            background-size: 400% 400%;
            animation: gradientAnimation 10s ease infinite;
        }

        @keyframes gradientAnimation {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* コンテナのスタイル */
        .container {
            background: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            padding: 30px;
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h1 {
            color: #1d3557;
            font-size: 28px;
            margin-bottom: 20px;
        }

        label {
            font-size: 16px;
            color: #555;
        }

        input[type="number"] {
            width: 80px; /* テキストエリアの幅を再調整 */
            height: 50px; /* テキストエリアの高さを再調整 */
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
            text-align: center; /* 中央揃え */
        }

        button {
            background: #1d3557;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        button:hover {
            background: #457b9d;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>数字当てゲーム</h1>
        <form action="guess" method="POST">
            <label for="guess">予想する数字 (1〜100): </label>
            <!-- テキストエリアのサイズを制限 -->
            <input type="number" name="guess" id="guess" required min="1" max="100">
            <button type="submit">送信</button>
        </form>
    </div>
</body>
</html>
