const assert = require('assert'),
	stdout = require("test-console").stdout;
	console = require('console');


let PersonClient = require('../../app/exo3/person-client');
let Person = require('../../app/exo3/person');


describe('Person client', function () {
	let client;
	let out;
	
	beforeEach(function () {
		client = new PersonClient();
		out = console;
	});
	
	it('should write the user identity using all clients when the user has no middle name', function () {
		let bobSmith = new Person("Smith", "Bob", null);
		
		let output = stdout.inspectSync(function(){
			 client.client1(out, bobSmith);
		});
		
		assert.equal(output.toString(), 'Bob\n, \n,Smith\n');
		assert.equal(client.client2(bobSmith), "Smith, Bob");
		
		output = stdout.inspectSync(function(){
			client.client3(out, bobSmith);
		});
		
		assert.equal(output.toString(), 'Smith\n,, \n,Bob\n');
		assert.equal(client.client4(bobSmith), "Smith, Bob");
	});
	
	it('should write the user identity using all clients when the user has a middle name', function () {
		let jennyJJones = new Person("Jones", "Jenny", "J");
		
		let output = stdout.inspectSync(function(){
			client.client1(out, jennyJJones);
		});
		
		assert.equal(output.toString(), 'Jenny\n, \n,J\n, \n,Jones\n');
		assert.equal(client.client2(jennyJJones), "Jones, Jenny J");
		
		output = stdout.inspectSync(function(){
			client.client3(out, jennyJJones);
		});
		
		assert.equal(output.toString(), 'Jones\n,, \n,Jenny\n, \n,J\n');
		assert.equal(client.client4(jennyJJones), "Jones, Jenny J");
	});
	
	
});