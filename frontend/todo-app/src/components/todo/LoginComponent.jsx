import {useState} from "react";
import {useNavigate} from "react-router-dom";

function LoginComponent() {

    const[username, setUsername] = useState('admin')
    const[password, setPassword] = useState('')
    const[showSuccessMessage, setSuccessMessage] = useState(false)
    const[showErrorMessage, setErrorMessage] = useState(false)

    const navigate = useNavigate()



    function handleUserNameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    function handleSubmit() {
        if(username === 'admin' && password === 'dummy'){
            setSuccessMessage(true)
            setErrorMessage(false)
            navigate(`/welcome/${username}`)
        }else {
            setSuccessMessage(false)
            setErrorMessage(true)
        }
    }

    function SuccessMessageComponent() {
        if(showSuccessMessage) {
            return <div className="successMessage">Authenticated Successfully</div>
        }

        return null
    }

    function ErrorMessageComponent() {
        if(showErrorMessage) {
            return <div className="errorMessage">Authentication Failed. Please check your credentials</div>
        }

        return null
    }


    return(
        <div className="Login">
            {showSuccessMessage && <div className="successMessage">Authenticated Successfully</div>}
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