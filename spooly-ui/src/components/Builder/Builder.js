import React from 'react';
import PropTypes from 'prop-types';
import styles from './Builder.module.scss';

const Builder = () => (
  <div className={styles.Builder} data-testid="Builder">
    Builder Component
  </div>
);

Builder.propTypes = {};

Builder.defaultProps = {};

export default Builder;
