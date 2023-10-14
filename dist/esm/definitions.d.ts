export interface saveimagePlugin {
    saveBase64ToGallery(options: {
        base64String: string;
        folderName: string;
    }): Promise<{
        base64String: string;
        folderName: string;
    }>;
}
