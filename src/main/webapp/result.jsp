<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>結果</title>
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

        p {
            font-size: 16px;
            color: #555;
            margin: 10px 0;
        }

        a {
            display: inline-block;
            background: #1d3557;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.2s ease, background 0.2s ease;
        }

        a:hover {
            background: #457b9d;
            transform: scale(1.1);
        }

        a:active {
            background: #1d3557;
            transform: scale(1.0);
        }

        /* 追加の装飾 */
        .decoration {
            position: absolute;
            top: -20px;
            left: -20px;
            right: -20px;
            bottom: -20px;
            z-index: -1;
        }

        .decoration::before, .decoration::after {
            content: '';
            position: absolute;
            border: 5px solid rgba(255, 255, 255, 0.5);
            border-radius: 50%;
            width: 100px;
            height: 100px;
            animation: spin 6s linear infinite;
        }

        .decoration::before {
            top: 20%;
            left: 10%;
            animation-delay: -3s;
        }

        .decoration::after {
            bottom: 20%;
            right: 10%;
        }

        @keyframes spin {
            0% { transform: scale(0.8) rotate(0deg); }
            50% { transform: scale(1.2) rotate(180deg); }
            100% { transform: scale(0.8) rotate(360deg); }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>結果</h1>
        <p>${message}</p>
        <p>${hint}</p>
        <br>
        <a href="index.jsp">もう一度試す</a>
    </div>
    <div class="decoration"></div>
</body>
</html>
