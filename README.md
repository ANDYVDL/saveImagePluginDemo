# save-image-plugin-demo

This plugin is created with Capacitor 4 to demonstrate the functionality of saving image to external storage directory.

## Install

```bash
npm install save-image-plugin-demo
npx cap sync
```

## API

<docgen-index>

* [`saveBase64ToGallery(...)`](#savebase64togallery)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### saveBase64ToGallery(...)

```typescript
saveBase64ToGallery(options: { base64String: string; folderName: string; }) => Promise<{ base64String: string; folderName: string; }>
```

| Param         | Type                                                       |
| ------------- | ---------------------------------------------------------- |
| **`options`** | <code>{ base64String: string; folderName: string; }</code> |

**Returns:** <code>Promise&lt;{ base64String: string; folderName: string; }&gt;</code>

--------------------

</docgen-api>
