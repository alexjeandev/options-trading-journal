function Hero() {
    return (
        <div className="isolate relative flex flex-col items-center justify-center min-h-[400px] gap-5">
            <p className="text-lavender tracking-widest bg-card rounded-full font-extralight px-3 py-1  border border-border">CALLS PUTS & PANCAKES</p>

            <div className="absolute w-96 h-96 bg-violet blur-3xl opacity-20 -z-10"></div>

            <h1 className="relative text-5xl font-bold leading-tight">
                <span className="bg-linear-to-r from-white via-silver to-violet bg-clip-text text-transparent">
                    Your Options Journal.
                </span>

                <span aria-hidden="true" className="hero-shine absolute inset-0">
                    Your Options Journal.
                </span>
            </h1>

            <p className="text-nav-link ">Track your calls and puts, review your performance, and keep journaling simple.</p>

            <a href="" className="bg-violet text-gray-200 px-4 py-2.5 rounded-full
            hover:bg-purple-500 transition-colors duration-300 font-normal text-sm ">Get started</a>
        </div>
    )
}
export default Hero