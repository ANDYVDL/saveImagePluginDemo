import { WebPlugin } from '@capacitor/core';
export class saveimageWeb extends WebPlugin {
    async saveBase64ToGallery(options) {
        console.log('ECHO', options);
        return options;
    }
    async downloadFileFromURL(options) {
        return options;
    }
}
//# sourceMappingURL=web.js.map