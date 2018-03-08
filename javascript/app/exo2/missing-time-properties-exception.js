function MissingTimePropertiesException(message) {
	this.message = message;
	
	this.stack = (new Error()).stack;
	
	MissingTimePropertiesException.prototype = Object.create(Error.prototype);
	MissingTimePropertiesException.prototype.name = "MissingTimePropertiesException";
}

module.exports = MissingTimePropertiesException;