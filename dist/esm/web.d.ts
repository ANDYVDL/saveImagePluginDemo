import { WebPlugin } from '@capacitor/core';
import type { saveimagePlugin } from './definitions';
export declare class saveimageWeb extends WebPlugin implements saveimagePlugin {
    saveBase64ToGallery(options: {
        base64String: string;
        folderName: string;
    }): Promise<{
        base64String: string;
        folderName: string;
    }>;
}
