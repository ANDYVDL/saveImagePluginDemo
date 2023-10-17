import { WebPlugin } from '@capacitor/core';

import type { saveimagePlugin } from './definitions';

export class saveimageWeb extends WebPlugin implements saveimagePlugin {
  async saveBase64ToGallery(options: { base64String: string, folderName: string }): Promise<{ base64String: string, folderName: string }> {
    console.log('ECHO', options);
    return options;
  }

  async downloadFileFromURL(options: { url: string}): Promise<{ url: string }> {
    return options;
  }
}
