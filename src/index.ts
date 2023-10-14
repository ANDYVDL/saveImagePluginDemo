import { registerPlugin } from '@capacitor/core';

import type { saveimagePlugin } from './definitions';

const saveimage = registerPlugin<saveimagePlugin>('saveimage', {
  web: () => import('./web').then(m => new m.saveimageWeb()),
});

export * from './definitions';
export { saveimage };
