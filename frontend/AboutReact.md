## Exploring React App Folder Structure

- `package.json` : Define dependencies (Similar to Maven pom.xml)
- `node_modules` : Folder where all the dependencies are downloaded to 
- React Initialization
  - `public/index.html`: Contains `root` div
  - `src/index.js` : Initializes React App. Loads App Component
    - `src/index.css` : Styling for entire application
  - `src/App.js` : Code for App Component
    - `src/App.css` : Styling for App Component
    - `src/App.test.js` : Unit tests for App Component
- React Components
  - Parts of a Component
    - View (JSX or JavaScript)
    - Logic (JavaScript)
    - Styling (CSS)
    - State (Internal Data Store)
    - Props (Pass Data)

## JSX - Views with React
- React project use **JSX** for presentation
- Stricter than HTML
  - Close tags are mandatory
  - Only one top-level tag allowed:
    - Cannot return multiple top-level JSX tags
    - Wrap into a shared parent
      - `<div>..</div> or <> ..</> (empty wrapper)`
- How JSX enabled in React Project
  - Different browsers have different support levels modern JS features
    - **Babel** converts JSX to JS
  - Parentheses() make returning complex JSX values easier
  - Custom components should start with upper case letter
    - For HTML you should use small case
  - Specify CSS class - className
    - Similar to HTML class attribute
- Each Component in it's own file (or module)
  - To use a class from a different module, you need to import it.
  - There can be only one default export from a module 
    - **Default import**
      - `import FirstComponent from './components/FirstComponent';`
    - **Named import**
      - `import { FourthComponent } from './components/FourthComponent';`

## State in React
- **State**: Built-in React object used to contain data or information about the component
- **(REMEMBER)** In earlier versions of React, Only Class Components can have state
  - And implementing state was very complex!
- Hooks were introduced in React 16.8
  - Hooks are very easy to use
  - **useState** hook allows adding state to Function Component
    - useState return two things
      - 1. Current State
        2. A function to update state
  - Each instance of component has it's own state
  - 