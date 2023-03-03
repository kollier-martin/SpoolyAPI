import React, { lazy, Suspense } from 'react';

const LazyBuilder = lazy(() => import('./Builder'));

const Builder = props => (
  <Suspense fallback={null}>
    <LazyBuilder {...props} />
  </Suspense>
);

export default Builder;
