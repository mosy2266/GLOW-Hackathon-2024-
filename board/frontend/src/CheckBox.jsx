export function CheckBox({children, disabled, checked, onChange_check}) {
    return (
        <label>
            <input 
            type="checkbox"
            disabled={disabled} 
            checked={checked}
            onChange_check={(event) => onchange(event.target.checked)}
            />
            {children}
        </label>

    );
}