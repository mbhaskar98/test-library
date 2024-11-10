import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'bob-test' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null;

const BobTestModule = isTurboModuleEnabled
  ? require('./NativeBobTest').default
  : NativeModules.BobTest;

const BobTest = BobTestModule
  ? BobTestModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return BobTest.multiply(a, b);
}
