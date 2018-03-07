const assert = require('assert'),
	stdout = require("test-console").stdout;
	console = require('console');


let PersonClient = require('../../app/exo3/personClient');
let Person = require('../../app/exo3/person');


describe('Person client', function () {
	let client;
	
	beforeEach(function () {
		client = new PersonClient();
		
	});
	
	it('Should write name using different clients', function () {
		let bobSmith = new Person("Smith", "Bob", null);
		let out = console;
		
		let output = stdout.inspectSync(function(){
			 client.client1(out, bobSmith);
		});
		
		assert.deepEqual(output.toString(), 'Bob\n, \n,Smith\n');
		assert.equal(client.client2(bobSmith), "Smith, Bob");
		
		out = console;
		
		output = stdout.inspectSync(function(){
			client.client3(out, bobSmith);
		});
		
		assert.deepEqual(output.toString(), 'Smith\n,, \n,Bob\n');
		assert.equal(client.client4(bobSmith), "Smith, Bob");
		
	});
	
	
});