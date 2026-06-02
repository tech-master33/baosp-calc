# baosp-calc

[![Android CI — baosp-calc](https://github.com/tech-master33/baosp-calc/actions/workflows/android.yml/badge.svg)](https://github.com/tech-master33/baosp-calc/actions/workflows/android.yml)

An accessible calculator with large touch targets, voice announcement of every button press, and full screen reader support. Part of the [BAOSP](https://github.com/tech-master33/baosp) ecosystem.

## Download

**Latest APK → [github.com/tech-master33/baosp/releases/tag/nightly](https://github.com/tech-master33/baosp/releases/tag/nightly)**

A fresh build is posted there automatically every night alongside the screen reader, TTS engine, launcher, clock, and panel.
You can also find standalone builds on the [releases page](https://github.com/tech-master33/baosp-calc/releases) of this repo.

## Features

- **72dp touch targets** — every button large enough to hit without precise aiming
- **Voice announcement** — every key press and result spoken aloud
- **Full screen reader support** — all buttons properly labelled for baosp-screenreader
- **Expression evaluator** — full arithmetic expressions (e.g. `3 + 4 × 2`) evaluated correctly
- **Result announcement** — result read aloud when equals is pressed
- **Error handling** — division by zero and invalid input announced clearly, not silently ignored

## Installing on your device

1. Download the APK from the nightly link above
2. Transfer it to your Android device
3. Install it (allow unknown sources if prompted)
4. Open **BAOSP Calc** from your app drawer

## Building locally

```bash
git clone https://github.com/tech-master33/baosp-calc.git
cd baosp-calc
chmod +x gradlew
./gradlew assembleDebug
# APK at: app/build/outputs/apk/debug/app-debug.apk
```

Requires JDK 17 and Android SDK with API level 34.

## CI/CD

Every push to `master` automatically builds a new APK and posts it as a GitHub Release.
The badge above shows whether the latest build passed or failed.

## BAOSP Ecosystem

baosp-calc is part of BAOSP — an accessible Android platform for blind and visually impaired users:

| Repo | What it does |
|------|-------------|
| [baosp](https://github.com/tech-master33/baosp) | Main project — nightly bundle, coordination |
| [baosp-screenreader](https://github.com/tech-master33/baosp-screenreader) | Screen reader — accessibility service |
| [baosp-tts](https://github.com/tech-master33/baosp-tts) | SVOX Pico TTS engine |
| [aoler](https://github.com/tech-master33/aoler) | Accessible home screen launcher |
| [baosp-clock](https://github.com/tech-master33/baosp-clock) | Accessible clock, alarm, timer |
| **[baosp-calc](https://github.com/tech-master33/baosp-calc)** | **Accessible calculator (this repo)** |
| [baosp-panel](https://github.com/tech-master33/baosp-panel) | Quick-access control panel |

All APKs are bundled together and published every night at  
**[github.com/tech-master33/baosp/releases/tag/nightly](https://github.com/tech-master33/baosp/releases/tag/nightly)**

## License

Apache License 2.0 — same as BAOSP and AOSP.
