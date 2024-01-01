

const Person = {
    name: 'admin',
    address: {
        line1: '123 Baker Street',
        city: 'London',
        country: 'UK'
    },
    profiles: ['X', 'LinkedIn', 'Instagram'],
    printprofile: () => {
        Person.profiles.map(
            (profile) => {
                console.log(profile)
            }
        );
    }
}


function LearningJavaScript() {
    return(
        <>
        <div>{Person.name}</div>
        <div>{Person.address.country}</div>
        <div>{Person.printprofile()}</div>

        </>  
    );
}

export default LearningJavaScript;