function Game(s) {
	this.move = move;
	this.winner = winner;
	
	let board = s;
	let initBoard = s;
	
	function Game(s, position, player) {
		initBoard = s;
		board = s;
		board = board.concat(s);
		board = board.replaceAt(position, player);
	}
	
	function move(player) {
		for (let i = 0; i < 9; i++) {
			if (board.charAt(i) === '-') {
				let game = play(i, player);
				if (game.winner() === player)
					return i;
			}
		}
		
		for (let i = 0; i < 9; i++) {
			if (initBoard.charAt(i) == '-')
				return i;
		}
		return -1;
	}
	
	function winner() {
		if (board.charAt(0) != '-' && board.charAt(0) == board.charAt(1) && board.charAt(1) == board.charAt(2))
			return board.charAt(0);
		
		if (board.charAt(3) != '-' && board.charAt(3) == board.charAt(4)  && board.charAt(4) == board.charAt(5))
			return board.charAt(3);
		
		if (board.charAt(6) != '-' && board.charAt(6) == board.charAt(7)   && board.charAt(7) == board.charAt(8))
			return board.charAt(6);
		
		return '-';
	}
	
	
	function play(i, player) {
		let game = new Game(initBoard, i, player);
		return game;
	}
	
	Game.prototype.winner = winner;
	
	String.prototype.replaceAt = function(index, char) {
		let a = this.split("");
		a[index] = char;
		return a.join("");
	}
}

module.exports = Game;