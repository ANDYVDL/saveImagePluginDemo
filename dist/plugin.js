var capacitorsaveimage = (function (exports, core) {
    'use strict';

    const saveimage = core.registerPlugin('saveimage', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.saveimageWeb()),
    });

    class saveimageWeb extends core.WebPlugin {
        async saveBase64ToGallery(options) {
            console.log('ECHO', options);
            return options;
        }
        async downloadFileFromURL(options) {
            return options;
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        saveimageWeb: saveimageWeb
    });

    exports.saveimage = saveimage;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
