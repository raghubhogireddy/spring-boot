import {Link, useParams} from "react-router-dom";

function WelcomeComponent() {

    const {username} = useParams()

    console.log(username)

    return(
        <div className="Welcome">
            <h1>Welcome, {username}</h1>
            <div>
                Your todos. <Link to ="/todos">Manage your todos here</Link>
            </div>
        </div>
    );
}

export default WelcomeComponent;