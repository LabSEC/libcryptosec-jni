#ifndef ENUMCONVERSIONEXCEPTION_H_
#define ENUMCONVERSIONEXCEPTION_H_

class EnumConversionException : public LibCryptoSecException {

protected:
	std::string message;

public:
	EnumConversionException(std::string message){
		this->message = message;
	}

	virtual ~EnumConversionException() throw() {};

	virtual std::string getMessage() const {
		return this->message;
	}

    virtual std::string toString() const {
    	return this->message;
    }
};

#endif /* ENUMCONVERSIONEXCEPTION_H_ */
