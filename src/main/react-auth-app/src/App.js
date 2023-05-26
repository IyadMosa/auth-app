import React, { useEffect } from "react";
import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from "react-router-dom";
import { Provider } from "react-redux";
import LoginPage from "./components/LoginPage";
import store from "./store";
import { NavbarScroller } from "@iyadmosa/react-library";
import UserPage from "./components/UserPage";
import Dashboard from "./components/Dashboard";

const PrivateRoute = ({ component: Component, ...rest }) => {
  const isAuthenticated = !!localStorage.getItem("token");
  return (
    <Route
      {...rest}
      render={(props) =>
        isAuthenticated ? <Component {...props} /> : <Redirect to="/" />
      }
    />
  );
};

const App = () => {
  const brand = { name: "Dashboard", to: "/dashboard" };
  const links = [
    {
      name: "Dashboard",
      to: "/dashboard",
      component: <Dashboard />,
    },
  ];

  // Check if the current location is the login page
  let showNavbar = window.location.pathname !== "/";

  useEffect(() => {
    showNavbar = window.location.pathname !== "/";
  }, [window.location.pathname]);

  return (
    <Provider store={store}>
      <Router>
        {showNavbar && (
          <NavbarScroller user={<UserPage />} brand={brand} links={links} />
        )}
        <Switch>
          <Route exact path="/" component={LoginPage} />
          <PrivateRoute path="/dashboard" component={Dashboard} />
        </Switch>
      </Router>
    </Provider>
  );
};

export default App;
