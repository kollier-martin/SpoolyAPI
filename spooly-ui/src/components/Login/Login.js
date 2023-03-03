import React from 'react';
import PropTypes from 'prop-types';
import styles from './Login.module.scss';

const Login = () => (
  <div className={styles.Login} data-testid="Login">
    Login Component
  </div>
);

Login.propTypes = {};

Login.defaultProps = {};

export default Login;
