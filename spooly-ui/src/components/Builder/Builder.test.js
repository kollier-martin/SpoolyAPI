import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import Builder from './Builder';

describe('<Builder />', () => {
  test('it should mount', () => {
    render(<Builder />);
    
    const builder = screen.getByTestId('Builder');

    expect(builder).toBeInTheDocument();
  });
});