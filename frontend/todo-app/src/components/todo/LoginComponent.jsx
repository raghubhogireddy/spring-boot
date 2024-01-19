import {useState} from "react";
import {useNavigate} from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function LoginComponent() {

    const[username, setUsername] = useState('admin')
    const[password, setPassword] = useState('')
    const[showErrorMessage, setErrorMessage] = useState(false)

    const navigate = useNavigate()

    const authContext = useAuth();



    function handleUserNameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if(authContext.login(username, password)){
            navigate(`/welcome/${username}`)
        }else {
            setErrorMessage(true)
        }
    }


    return(
        <div className="Login">
            {showErrorMessage && <div className="errorMessage">Authentication Failed. Please check your credentials</div>}
            <div className="LoginForm">
                <div>
                    <label>User Name</label>
                    <input type="text" name="user_name" value={username} onChange={handleUserNameChange}/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
                </div>
            </div>
        </div>
    );
}

export default LoginComponent;