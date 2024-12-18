package number;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.GameBean;
import dao.GameDAO;

@WebServlet("/guess")
public class NumberGuessingGameServlet extends HttpServlet {
    private GameBean gameBean;
    private GameDAO gameDAO;

    @Override
    public void init() throws ServletException {
        // ゲームの初期化
        gameBean = new GameBean();
        gameBean.startNewGame(); // 新しいゲーム開始
 

        // ゲーム起動時に古いデータを削除
        gameDAO = new GameDAO();
        gameDAO.deleteAllGameResults(); // 古いゲーム結果を削除
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        boolean correct = (guess == gameBean.getTargetNumber());
        String message;
        String hint;

        // 試行回数をインクリメント
        gameBean.incrementAttempts();

        if (correct) {
            message = "正解！";
            hint = "答えは " + gameBean.getTargetNumber() + " でした！";
        } else if (guess < gameBean.getTargetNumber()) {
            message = "不正解！";
            hint = "もっと大きい数字です。";
        } else {
            message = "不正解！";
            hint = "もっと小さい数字です。";
        }

        // 結果をGameResultServletに渡す
        request.setAttribute("guess", guess);
        request.setAttribute("correct", correct);
        request.setAttribute("hint", hint);
        request.setAttribute("attempts", gameBean.getAttempts());

        if (correct) {
            gameBean.startNewGame(); // 次のゲーム用に初期化
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result");
        dispatcher.forward(request, response);
    }
}
