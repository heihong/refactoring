const assert = require('chai').assert;

let TimeProperties = require('../../app/exo2/time-properties');
let MissingTimePropertiesException = require('../../app/exo2/missing-time-properties-exception');

describe('Time Properties', function () {
	let timeProperties;
	let properties;
	
	beforeEach(function () {
		timeProperties = new TimeProperties();
		properties = {
			getProperty: function (name) {
			}
		}
	});
	
	xit('should raise an exception when the interval is missing', function () {
		assert.throws(() => timeProperties.getTimes(properties),
			MissingTimePropertiesException);
	});
	
	it('should raise an exception when the interval value is below or equal to 0', function () {
		let map = {};
		map["interval"] = "0";
		properties = {
			getProperty: function (name) {
				return map[name];
			}
		};
		
		assert.throws(() =>
				timeProperties.getTimes(properties),
			MissingTimePropertiesException,
			'monitor  interval > 0');
	});
	
	
});
