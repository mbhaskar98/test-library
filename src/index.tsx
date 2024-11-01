const TestLibrary = require('./NativeTestLibrary').default;

export function multiply(a: number, b: number): number {
  return TestLibrary.multiply(a, b);
}
