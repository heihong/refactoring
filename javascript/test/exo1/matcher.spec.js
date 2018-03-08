let assert = require('assert');
let Matcher = require('../../app/exo1/matcher');

describe('Matcher', function () {
	let matcher;
	let expected = [10, 50, 30, 98];
	let clipLimit = 100;
	let delta = 5;
	
	beforeEach(function () {
		matcher = new Matcher();
	});
	
	
	it('Should *MATCH* The difference between the actual entry and the expected one is below delta', function () {
		let actual = [12, 55, 25, 110];
		
		let matches = matcher.match(expected, actual, clipLimit, delta);
		
		assert.equal(matches, true);
	});
	
	it('Should *NOT* match when the difference between the actual entry and the expected one is above delta', function () {
		let actual = [10, 60, 30, 98];
		
		let matches = matcher.match(expected, actual, clipLimit, delta);
		
		assert.equal(matches, false);
	});
	
	it('should *NOT* match when the actual and the expected have different length', function () {
		let actual = [10, 50, 30];
		
		let matches = matcher.match(expected, actual, clipLimit, delta);
		
		assert.equal(matches, false);
	
	});
});