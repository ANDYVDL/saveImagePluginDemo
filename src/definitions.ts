export interface saveimagePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
