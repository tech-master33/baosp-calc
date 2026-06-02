# Contributing to baosp-calc

Thank you for contributing to baosp-calc, the accessible calculator built for BAOSP.
This guide is written to work well with screen readers and keyboard-only navigation.
Every step is numbered and linear — no visual layout is assumed.

---

## Ways to contribute

1. Report a bug — describe something that does not work as expected
2. Request a feature — describe something that would help blind users
3. Report a mispronounced number or operator — something the screen reader reads wrongly
4. Improve documentation — fix unclear steps or add missing information
5. Test builds — install nightly APKs and report accessibility issues
6. Write code — fix bugs or add features

---

## Claiming an issue

1. Open the issue you want to work on
2. Read the full description, including the "Where to start" section if there is one
3. Leave a comment: "I'd like to take this on"
4. Wait for a maintainer to assign it to you before starting

---

## Before you start

1. A GitHub account — github.com/join
2. Git — git-scm.com
3. Android Studio or VS Code
4. Java 17 — adoptium.net
5. Android SDK (API level 34) — installed by Android Studio

---

## Step 1 — Fork

1. Open github.com/tech-master33/baosp-calc
2. Activate Fork → Create fork
3. Your copy is at github.com/YOUR-USERNAME/baosp-calc

---

## Step 2 — Clone

```bash
git clone https://github.com/YOUR-USERNAME/baosp-calc.git
cd baosp-calc
git remote add upstream https://github.com/tech-master33/baosp-calc.git
```

---

## Step 3 — Branch

```bash
git checkout -b your-branch-name
```

Examples: `fix/divide-by-zero-crash`, `feature/memory-buttons`, `a11y/result-announcement`

---

## Step 4 — Make changes

Key files:

- `app/src/main/java/org/baosp/calc/` — all Kotlin source
- `app/src/main/res/` — XML layouts and strings
- `app/src/main/AndroidManifest.xml` — permissions and components

### Accessibility rules

1. Every button must have a `contentDescription` that names the digit or operator clearly
2. Touch targets must be at least 48dp (currently 72dp — do not make them smaller)
3. All user-facing strings must be in `strings.xml`
4. Every key press must trigger a TTS announcement — the button label and then the current expression
5. The result must be announced clearly when equals is pressed
6. Errors (divide by zero, invalid input) must be announced, not displayed silently
7. Test with the screen reader on before submitting

---

## Step 5 — Build and test

```bash
chmod +x gradlew
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```

Checklist:
- App builds without errors
- Every button announces its label when tapped
- Full expressions are read back correctly (e.g. "3 plus 4 equals 7")
- Divide by zero announces "Error: divide by zero"
- Clear button resets and announces "cleared"
- All buttons reachable by swipe navigation

---

## Step 6 — Commit

```bash
git add .
git commit -m "fix: result not announced after equals press

The equals handler updated the display text but did not call
the TTS engine. Added a ttsManager.speak(result) call."
```

Types: `fix`, `feature`, `docs`, `refactor`, `a11y`, `test`

---

## Step 7 — Push and pull request

```bash
git push origin your-branch-name
```

1. Open github.com/YOUR-USERNAME/baosp-calc
2. Activate Compare and pull request
3. Title: one sentence — what changed
4. Description: what problem does this solve, how did you test it
5. Activate Create pull request

---

## Reporting a bug

1. Open github.com/tech-master33/baosp-calc/issues
2. Activate New issue → Bug report
3. Include: what calculation you tried, what was announced, your Android version and device

---

## Community

- Issues: github.com/tech-master33/baosp-calc/issues
- Discussions: github.com/tech-master33/baosp-calc/discussions
- Screen reader: github.com/tech-master33/baosp-screenreader
- TTS engine: github.com/tech-master33/baosp-tts
- BAOSP main: github.com/tech-master33/baosp
