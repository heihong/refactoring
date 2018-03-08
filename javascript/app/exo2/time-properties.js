const MissingTimePropertiesException = require('./missing-time-properties-exception');

function TimeProperties() {
	this.getTimes = getTimes;
	
	let monitorTime;
	let departureOffset;
	
	function TimeProperties (departureOffset, monitorTime){
		this.departureOffset = departureOffset;
		this.monitorTime = monitorTime;
	}
	
	function getTimes(props) {
		 let valueString;
		 let value;
		
		valueString = props.getProperty("interval");
		if (valueString == null)
			throw new MissingTimePropertiesException("monitor  interval");
		
		value = parseInt(valueString, 16);
		if (value <= 0)
			throw new MissingTimePropertiesException("monitor  interval > 0");
		
		 let checkInterval = value;
		
		valueString  = props.getProperty("duration");
		if (valueString == null)
			throw new MissingTimePropertiesException("duration");
		
		value = parseInt(valueString, 16);
		if (value <= 0)
			throw new MissingTimePropertiesException("duration > 0");
		
		if ((value % checkInterval) != 0)
			throw new MissingTimePropertiesException("duration % checkInterval");
		
		monitorTime = value;
		
		valueString = props.getProperty("departure");
		if (value == null)
			throw new MissingTimePropertiesException("departure offset");
		
		value = parseInt(valueString, 16);
		if (value <= 0)
			throw new MissingTimePropertiesException("departure > 0");
		
		
		if ((value % checkInterval) != 0)
			throw new MissingTimePropertiesException("departure % checkInterval");
		
		departureOffset = value;
		return new TimeProperties(departureOffset, monitorTime );
	}
}

module.exports = TimeProperties;