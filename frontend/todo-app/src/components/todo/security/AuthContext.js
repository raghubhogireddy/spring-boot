import {useState} from "react";

const {createContext} = require("react");

export const AuthContext = createContext()

function AuthProvider({children}) {
    
    const [number, setNumber] = useState(10);
    
    return (
        <AuthContext.Provider value={{number}}>
            {children}
        </AuthContext.Provider>
    );
}

export default AuthProvider;