import { WebPlugin } from '@capacitor/core';

import type { saveimagePlugin } from './definitions';

export class saveimageWeb extends WebPlugin implements saveimagePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
