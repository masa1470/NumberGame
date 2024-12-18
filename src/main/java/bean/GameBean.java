package bean;

public class GameBean {
    private int targetNumber;
    private int attempts;

    public GameBean() {
        this.attempts = 0; // 初期試行回数は0
    }

    public void startNewGame() {
        // 新しいゲームのためにターゲット番号を設定（例えば1-100の間）
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.attempts = 0; // 新しいゲームを開始する際に試行回数をリセット
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    // 試行回数をインクリメント
    public void incrementAttempts() {
        this.attempts++;
    }
}
