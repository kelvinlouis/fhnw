package ch.fhnw.oop2.testPrep.lambdas;

class Score {

	private Player player;
	private int round;
	private int points;

	public Score(Player player, int round, int points) {
		this.player = player;
		this.round = round;
		this.points = points;
	}

	public Player getPlayer() { return this.player; }

	public int getRound() { return this.round; }

	public int getPoints() { return this.points; }

	public String toString() {
		return "{" + this.player + ", " +
				"round:" + this.round + ", " +
				"points:" + this.points + "}";
	}
}