import { useState } from 'react';
import CounterButton from './CounterButton';
import './Counter.css'


function Counter() {

    const [count, setCount] = useState(0);

    function incrementCounter(by) {
        setCount(count + by)
    }

    function decrementCounter(by) {
        setCount(count - by)
    }

    function resetCounter() {
        setCount(0)
    }

    return(
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incrementCounter={incrementCounter} decrementCounter={decrementCounter}/>
            <CounterButton by={2} incrementCounter={incrementCounter} decrementCounter={decrementCounter}/>
            <CounterButton by={5} incrementCounter={incrementCounter} decrementCounter={decrementCounter}/>
            <button className="button resetButton" onClick={resetCounter}>Reset</button>

        </>
    );
}

export default Counter;