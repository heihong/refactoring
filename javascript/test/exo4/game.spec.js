let assert = require('assert');
let Game = require('../../app/exo4/game');

describe('Game', function () {
	
	it('testDefaultMove', function () {
		let game = new Game("XOXOX-OXO");
		let result = game.move('X');
		
		assert.equal(result, 5);
		
		game = new Game("XOXOXOOX-");
		result = game.move('O');
		
		assert.equal(result, 8);
		
		
		game = new Game("---------");
		result = game.move('X');
		
		assert.equal(result, 0);
		
		game = new Game("XXXXXXXXX");
		result = game.move('X');
		
		assert.equal(result, -1);
	});
	
	it('testFindWinningMove', function () {
		let game = new Game("XO-XX-OOX");
		
		let result = game.move('X');
		
		assert.equal(result, 5);
	});
	
	it('testWinConditions', function () {
		let game = new Game("---XXX---");
		
		let winner = game.winner();
		
		assert.equal(winner, 'X');
		
	});
});