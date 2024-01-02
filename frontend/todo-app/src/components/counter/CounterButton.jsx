import { PropTypes } from 'prop-types';

function CounterButton({by, incrementCounter, decrementCounter}) {

    return(
        <div className="Counter">
            <div>
                <button className="button counterButton" 
                onClick={() => incrementCounter(by)}>
                    +{by}</button>
                <button className="button counterButton"
                    onClick={() => decrementCounter(by)}>
                    -{by}
                </button>
            </div>
        </div>
    );
}

CounterButton.propTypes = {
    by: PropTypes.number
}


CounterButton.defaultProps = {
    by: 5
}

export default CounterButton;