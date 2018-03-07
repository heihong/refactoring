function Matcher() {
	this.match = match;
	
	function match(expected, actual, clipLimit, delta){
		for (let i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
		
		//Check for length differences
		if (actual.length != expected.length)
			return false;
		
		//Check that each entry within the expected +/- delta
		for (let i = 0; i < expected.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		
		return true;
	}
}
module.exports = Matcher;