# baosp-calc Roadmap

What we plan to build next, why it matters, and what state each item is in.

Open an issue or discussion before starting work on anything here so we can coordinate.

---

## Status key

- **Planned** — not started
- **In progress** — actively being worked on
- **Needs help** — no one assigned, good place to contribute
- **Done** — shipped in the nightly build

---

## Input

### History — Planned

**What it is:** Keep the last N calculations and allow the user to navigate back through them.

**Why it matters:** If the user mishears a result or wants to reuse a previous calculation, there is currently no way to retrieve it without re-entering everything.

**Proposed approach:** A scrollable list above the input field, navigable by swipe. Each entry announces the expression and result when focused.

---

### Copy result to clipboard — Needs help

**What it is:** Long-press or dedicated button to copy the current result to the clipboard.

**Why it matters:** Users often need to paste a calculated value into another app (email, notes, banking). Without copy, they have to remember and retype the number.

**Where to start:** `CalcActivity` — add a copy button next to the result. Use `ClipboardManager`. Announce "Copied" via TTS after copying.

---

### Memory buttons — Planned

**What it is:** M+, M−, MR, MC — store a value in memory and recall it.

**Why it matters:** Memory functions let users build multi-step calculations without writing anything down.

---

## Announcements

### Announce running expression — Needs help

**What it is:** As the user builds an expression (e.g. `3 + 4 ×`), read back the full expression so far each time a new token is entered.

**Why it matters:** Without visual feedback, the user has no way to verify what they have typed unless the screen reader reads it back at each step.

**Where to start:** The key press handler — after each digit or operator, call `ttsManager.speak(currentExpression)`.

---

### Pronunciation corrections — Needs help

**What it is:** Ensure operators are announced using plain words, not symbols.

**Why it matters:** Some TTS engines read `×` as "times" but others read it as a symbol or skip it. The app should always pass human-readable strings to TTS.

**Examples to fix:**
- `×` → "times"
- `÷` → "divided by"
- `−` → "minus"
- `√` → "square root of"

---

## Display

### Adjustable font size — Planned

**What it is:** Let the user choose a display font size for low-vision users who can see partially.

**Why it matters:** Some users are partially sighted — they can see large high-contrast text but not the standard display size.

---

## Scientific functions — Long term

**What it is:** Add trigonometric and logarithmic functions for users who need them.

**Why it matters:** Students and professionals who happen to be blind need the same calculator functions as sighted users.

**Status:** Not started. Basic arithmetic must be solid first.

---

## How priorities are set

Items move up the list when more users report being blocked or a contributor volunteers to lead the work.
Every item here has a stated impact on blind or disabled users.
