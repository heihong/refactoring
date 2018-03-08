function PersonClient() {
	
	this.client1 = client1;
	this.client2 = client2;
	this.client3 = client3;
	this.client4 = client4;
	
	function client1(out, person) {
		out.log(person.first);
		out.log(" ");
		if (person.middle != null) {
			out.log(person.middle);
			out.log(" ");
		}
		out.log(person.last);
	}
	
	function client2(person) {
		let result = person.last + ", " + person.first;
		if (person.middle != null)
			result += " " + person.middle;
		return result;
	}
	
	function client3(out, person) {
		out.log(person.last);
		out.log(", ");
		out.log(person.first);
		if (person.middle != null) {
			out.log(" ");
			out.log(person.middle);
		}
	}
	
	function client4(person) {
		return person.last + ", " +
			person.first +
			((person.middle == null) ? "" : " " + person.middle);
	}
}

module.exports = PersonClient;