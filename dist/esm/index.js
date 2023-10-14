import { registerPlugin } from '@capacitor/core';
const saveimage = registerPlugin('saveimage', {
    web: () => import('./web').then(m => new m.saveimageWeb()),
});
export * from './definitions';
export { saveimage };
//# sourceMappingURL=index.js.map