package com.demo.saveimage.capacitor;

import static android.text.TextUtils.isEmpty;

import android.content.Context;
import android.graphics.Bitmap;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "saveimage")
public class saveimagePlugin extends Plugin {

    private saveimage implementation = new saveimage();

    private Context mContext;

    @Override
    public void load() {
        super.load();
        this.mContext = getContext();
    }
    @PluginMethod
    public void saveBase64ToGallery(PluginCall call) {
        String base64String = call.getString("base64String");
        String folderName = call.getString("folderName");

        JSObject ret = new JSObject();
        if (isEmpty(base64String)) {
            ret.put("msg", "Base64 is empty");
            ret.put("isImageSaved", false);
            call.resolve(ret);
        }
        try {
            Bitmap bitmap = Base64Util.INSTANCE.decodeBase64ToBitmap(base64String);
            Base64Util.INSTANCE.saveBitmapAsPng(bitmap, this.mContext,isEmpty(folderName) ? "Image" : folderName);
            ret.put("isImageSaved", true);
            call.resolve(ret);
        } catch (Exception e) {
            e.printStackTrace();
            ret.put("msg", e.getLocalizedMessage());
            ret.put("isImageSaved", false);
            call.resolve(ret);
        }
    }
}
