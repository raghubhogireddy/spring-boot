import {Link, useParams} from "react-router-dom";
import { useState } from "react";
import { retrieveHelloWorldPathVariable } from "./api/HelloWorldApi";
import { retrieveAllTodosForUserName } from "./api/TodoApi";

function WelcomeComponent() {

    const {username} = useParams()
    const [message, setMessage] = useState()

    function helloWorldApi() {
        retrieveAllTodosForUserName("admin")
        .then((response) => successfulResponse(response))
        .catch((error) => errorResponse(error))
        .finally( () => console.log("Cleanup"))

    }

    function successfulResponse(response) {
        console.log(response)
        setMessage(response.data.message)
    }

    function errorResponse(error) {
        console.log(error)
    }

    return(
        <div className="Welcome">
            <h1>Welcome, {username}</h1>
            <div>
                Your todos. <Link to ="/todos">Manage your todos here</Link>
            </div>
            <div>
                <button className="btn btn-success" onClick={helloWorldApi}>Call API</button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    );
}

export default WelcomeComponent;