class Context {
	Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int action() {
		return strategy.algorithm();
	}
}