import {useState, createContext, useContext} from "react";


export const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)

function AuthProvider({children}) {
    const [isAuthenticated, setAuthenticated] = useState(false);
    
    const valueTobeShared = {isAuthenticated, login, logout}

    function login(username, password) {
        if (username === 'admin' && password === 'dummy') {
            setAuthenticated(true)
            return true
        }else {
            setAuthenticated(false)
            return false
        }
    }

    function logout() {
        setAuthenticated(false)
    }


    
    return (
        <AuthContext.Provider value={ valueTobeShared }>
            {children}
        </AuthContext.Provider>
    );
}

export default AuthProvider;